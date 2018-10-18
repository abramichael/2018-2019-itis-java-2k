<html>
<head>
    <script type="application/javascript"
            src="/js/jquery-1.9.1.js"></script>
</head>
<body>
<p><input type="text" id="text-input" oninput="g()"/></p>
<div id="found-list"/>

<script type="application/javascript">
    function g(request, response) {
        if ($("#text-input").val().length > 0) {
            $.ajax({
                url: "/doSearch",
                data: {
                    "q": $("#text-input").val()
                },
                success: function (msg) {

                    var lst = $("#found-list");
                    lst.html("");
                    for (let i = 0; i < msg.students.length; i++) {
                        lst.append("<li>" + msg.students[i] + "</li>")
                    }
                },
                error: function (msg) {
                    alert(2);
                }
            });
        } else {
            $("#found-list").html("");
        }
    }
</script>
</body>
</html>
