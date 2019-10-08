<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
    <g:javascript library='jquery' />
</head>
<body>
    

    
    <div id="content" role="main">
        <section class="row colset-2-its">
            <h1>Welcome to Grails</h1>

            <p>
                Congratulations, you have successfully started your first Grails application! At the moment
                this is the default page, feel free to modify it to either redirect to a controller or display
                whatever content you may choose. Below is a list of controllers that are currently deployed in
                this application, click on each to execute its default action:
            </p>

            
            <div>
                <form id = "searchForm">
                
                    <input type="text" name="search">
                    <button type="Submit" onclick="getResults()">Search</button>
                
                </form>
            </div>
            <div id= "showTweets">
                %{-- <g:render template="showTweets" collection="${showTweets}" var="tweet"/> --}%
            </div>
        </section>

    </div>

    <script>
function getResults()
    {   event.preventDefault();
        $.ajax({
            url:"<g:createLink url="[action:'getTweets',controller:'Twitter']" />",
            dataType: "json",
            type:"get",
            data: $('#searchForm').serialize(),
            success: function(data) {
                console.log(data)
                    $( "#showTweets" ).addClass( 'alert alert-info' ).html(data.data).show()
            }, 
            error: function(xhr, status, error) {
                 $( "#showTweets" ).append('Problem with fetch');
            }
        });
    }
</script>


</body>
</html>
