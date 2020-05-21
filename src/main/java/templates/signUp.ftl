


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Room</title>
</head>
<body>


<div class="container">
    <div class="container" >
        <h2>Sign Up For Free</h2>
        <form method="post">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" name="username" required class="form-control" placeholder="Enter username" id="email">
        </div>
        <div class="form-group">
            <label for="email">Password:</label>
            <input type="password" name="password" required class="form-control" placeholder="Enter password" id="email">
        </div>

            <div class="col-auto my-1">
                <label for="image">Gender:</label>
                <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Preference</label>
                <select class="custom-select mr-sm-2" name="gender" id="inlineFormCustomSelect">
                    <option selected>Choose...</option>
                    <option value="M" name="gender" >M</option>
                    <option value="F" name="Gender">F</option>
                </select>
            </div>

            <div class="form-group">
                <label for="image">Image:</label>
                <input type="text" name="imageURL" class="form-control" placeholder="Enter image path(Optional)" id="imageURL">
            </div>

            <div class="form-group form-check">
                <label class="form-check-label">
                    <input class="form-check-input" name="rememberMe" type="checkbox"> Remember me
                </label>
            </div>

        <button type="submit" class="btn btn-primary">Sign Up</button>
    </form>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>


