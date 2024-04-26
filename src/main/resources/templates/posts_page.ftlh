<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>POSTS</title>
</head>
<body>
<div>
    <#list posts as post>

    <div class="card" style="width: 18rem;">
        <img src="${post.url}" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title">Posts</h5>
            <p class="card-text">${post.description}</p>
            <a href="#" class="btn btn-primary">Go somewhere</a>
        </div>
    </div>
    </#list>

</div>
</body>
</html>