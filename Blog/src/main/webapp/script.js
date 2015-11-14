$(function () {
    var username = $("#username");
    username.focus(function () {
        if (this.value == "Type Your User Name")
            this.value = "";
    });
    username.blur(function () {
        if (this.value == "") {
            this.value = "Type Your User Name";
        }
    });
    $("#zhuce").click(function () {
        if (username.val() != "" && username.val() != "Type Your User Name") {
            $.ajax({
                type: "POST",
                url: "/user/register",
                contentType: "application/json",
                data: JSON.stringify({
                    id:$(".user1").val(),
                    password:$(".user2").val()
                }),
                success: function () {
                    window.location.href = "login.html";
                },
                error: function (xhr) {
                    alert("Error " + xhr.status);
                }
            });
        } else {
            alert("Please Type Your Username!");
        }
    });
    $("#denglu").click(function () {
        if (username.val() != "" && username.val() != "Type Your User Name") {
            $.ajax({
                type: "POST",
                url: "/user/login",
                contentType: "application/json",
                data: JSON.stringify({
                    id:$(".user1").val(),
                    password:$(".user2").val()
                }),
                success: function () {
                    window.location.href = "index.html";
                },
                error: function (xhr) {
                    alert("Error " + xhr.status);
                }
            });
        } else {
            alert("Please Type Your Username!");
        }
    });
});