package com.controller;

import com.common.Response;
import com.common.Status;
import com.entity.Article;
import com.entity.User;
import com.entity.UserArticle;
import com.repository.ArticleRepository;
import com.repository.UserArticleRepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vicriss on 2015/09/21.
 */
@Controller
@RequestMapping("/article")
@SessionAttributes("userId")
public class ArtcleController {

    private int status = Status.SUCCESS;

    @Autowired
    public ArticleRepository articleRepository;

    @Autowired
    public UserArticleRepository userArticleRepository;

    @Autowired
    public UserRepository userRepository;

    @ResponseBody
    @RequestMapping(value = "/articleId={id}", method = RequestMethod.GET)
    public Response findById(@ModelAttribute("userId") int userId, @PathVariable("id") int articleId) {
        UserArticle userArticleList = userArticleRepository.findByUserIdAndArticleId(userId, articleId);
        Article article = userArticleList.getArticle();
        if (article == null)
            status = Status.ERROR;
        return new Response(status, article);
    }

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Response findAll(@ModelAttribute("userId") int userId) {
        System.out.println("userId:" + userId);
        List<UserArticle> userArticleList = userArticleRepository.findByUserId(userId);
        if (userArticleList == null)
            status = Status.ERROR;
        return new Response(status, userArticleList);
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Response add(@ModelAttribute("userId") int userId, @RequestBody Article article) {
        articleRepository.save(article);
        if (article != null) {
            User user = userRepository.findOne(userId);
            UserArticle userArticle = new UserArticle(user, article);
            userArticleRepository.save(userArticle);
        } else
            status = Status.ERROR;
        return new Response(status);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{articleId}", method = RequestMethod.POST)
    public Response delete(@ModelAttribute("userId") int userId, @PathVariable("articleId") int articleId) {
        try {
            userArticleRepository.delete(articleId);
            articleRepository.delete(articleId);
        } catch (Exception e) {
            e.printStackTrace();
            status = Status.ERROR;
        }
        return new Response(status);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Response fileUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            String filePath = request.getSession().getServletContext().getRealPath("/image/")
                    + file.getOriginalFilename();

            try {
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
                status = Status.ERROR;
            }
        }
        return new Response(status);
    }

    @RequestMapping(value = "/upload2", method = RequestMethod.POST)
    public Response fileUpload2(HttpServletRequest request, HttpServletResponse response) {
        CommonsMultipartResolver cmr = new CommonsMultipartResolver(request.getServletContext());

        if (cmr.isMultipart(request)) {
            MultipartHttpServletRequest mReq = (MultipartHttpServletRequest) request;
            Iterator<String> files = mReq.getFileNames();

//            while (files.hasNext()){
            MultipartFile mf = mReq.getFile(files.next());

            if (mf != null) {
                String fileName = mf.getOriginalFilename();
                String path = request.getServletContext().getRealPath("/img/") + fileName;
                File file = new File(path);
                if (!file.exists())
                    file.mkdirs();
                try {
                    mf.transferTo(file);
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                    request.getSession().setAttribute("imgpath", path);
                    System.out.println(path);
                } catch (IOException e) {
                    status = Status.ERROR;
                    e.printStackTrace();
                }
            }
        }
//        }
        return new Response(status);
    }

    @RequestMapping(value = "/showImg", method = RequestMethod.GET)
    public Response showImg(HttpServletRequest request, HttpServletResponse response) {
        String path = (String) request.getSession().getAttribute("imgpath");
        File img = new File(path);

        try {
            FileInputStream fis = new FileInputStream(img);
            OutputStream os = response.getOutputStream();
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            int data = -1;
//
//            while ((data = fis.read()) != -1)
//                bos.write(data);
//
            byte[] buffer = new byte[fis.available()];
            int len = fis.read(buffer);
            while (len != -1)
                os.write(buffer);
            os.flush();
            fis.close();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Response(status);
    }
}
