<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Test FullStack</title>
    <!-- Fonts -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>
    <link href="https://fonts.googleapis.com/css?family=Lato:100,300,400,700" rel='stylesheet' type='text/css'>

    <!-- Styles -->
    <link href="app/css/app.min.css" rel="stylesheet">
  </head>

  <body>

    <div ng-controller="MainController as main">
      <nav class="navbar navbar-default">
        <div class="container">
          <div class="navbar-header">

            <!-- Branding Image -->
            <a class="navbar-brand" href="{{ url('/') }}">
              Inventory
            </a>
          </div>

        </div>
      </nav>

      <div ng-view>
        <!-- View Angular -->
      </div>
    </div>

    <!-- JavaScripts -->
    <script src="app/js/app.min.js"></script>
  </body>
</html>
