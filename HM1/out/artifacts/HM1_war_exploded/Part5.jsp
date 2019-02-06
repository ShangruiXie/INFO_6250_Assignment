<%--
  Created by IntelliJ IDEA.
  User: Xie
  Date: 1/26/2019
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Part3</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
</head>
<style>
    label{
        text-align: right;
    }

</style>


<body>
<h2 style="text-align: center">Part 5</h2><br/>
<form method="post" action="Part3Servlet" enctype="multipart/form-data">

    <div class="form-group row">
        <label for="email" class="col-sm-2 col-form-label" >Email</label>
        <div class="col-sm-5">
            <input type="text" class="form-control col-" id="email" name="email" placeholder="email@example.com">
        </div>
    </div>
    <div class="form-group row">
        <label for="password" class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-5">
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>
    </div>
    <div class="form-group row">
        <label for="confPass" class="col-sm-2 col-form-label">Confirm Password</label>
        <div class="col-sm-5">
            <input type="password" class="form-control" id="confPass" name="confPass" placeholder="Password">
        </div>
    </div>



    <fieldset class="form-group">
        <div class="row">
            <legend class="col-form-label col-sm-2 pt-0" style="text-align: right">Gender</legend>
            <div class="col-sm-5">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="Male" value="Male" checked>
                    <label class="form-check-label" for="Male">
                        Male
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="Female" value="Female">
                    <label class="form-check-label" for="Female">
                        Female
                    </label>
                </div>
            </div>
        </div>
    </fieldset>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Hobby</label>
        <div class="col-sm-5">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="Basketball" name="hobby" value="Basketball">
                <label class="form-check-label" for="Basketball">
                    Basketball
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="Football" name="hobby" value="Football">
                <label class="form-check-label" for="Football">
                    Football
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="Baseball" name="hobby" value="Baseball">
                <label class="form-check-label" for="Baseball">
                    Baseball
                </label>
            </div>
        </div>
    </div>

    <div class="form-group row">
        <label for="country" class="col-sm-2 col-form-label">Select Country</label>
        <div class="col-sm-5">
            <select class="custom-select my-1 mr-sm-2" id="country" name="country">
                <option selected>Choose...</option>
                <option value="China">China</option>
                <option value="United Kingdom">United Kingdom</option>
                <option value="United States">United States</option>
            </select>
        </div>
    </div>

    <div class="form-group row">
        <label for="address" class="col-sm-2 col-form-label">Address</label>
        <div class="col-sm-5">
            <textarea class="form-control" id="address" rows="3" name="address"></textarea>
        </div>
    </div>


    <div class="form-group row">
        <label class="col-sm-2 col-form-label"></label>
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </div>

    <%--<input type="button" name="Part3" value="Part3" onclick="Part3()">--%>
    <%--<input type="button" name="Part4" value="Part4" onclick="Part4()">--%>
    <%--<input type="button" name="Part5" value="Part5" onclick="Part5()">--%>
</form>


<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>

