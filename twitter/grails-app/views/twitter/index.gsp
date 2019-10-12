<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Search Tweet!!</title>
    <g:javascript library='jquery'/>
</head>

<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Search Tweet!!</h1>

        <div>
            <form id="searchForm">

                <input type="text" name="search">
                <button type="Submit" onclick="getResults()">Search</button>

            </form>
        </div>

        <div id="showTweets">
        </div>
    </section>

</div>

<script>
    function getResults() {
        event.preventDefault();
        $.ajax({
            url: "<g:createLink url="[action:'getTweets',controller:'Twitter']" />",
            dataType: "json",
            type: "get",
            data: $('#searchForm').serialize(),
            success: function (data) {
                $("#showTweets").addClass('alert alert-info').html("").show()

                $.each(data.data, function (index, value) {
                    $("#showTweets").addClass('alert alert-info').append("Name: " + value.name).show()
                    $("#showTweets").addClass('alert alert-info').append("<br/>").show()
                    $("#showTweets").addClass('alert alert-info').append("Tweet: " + value.text).show()
                    $("#showTweets").addClass('alert alert-info').append("<br/><br/>").show()
                });
                if(data.data.length == 0){
                    $("#showTweets").addClass('alert alert-info').append("No Results Found").show()
                }
            },
            error: function (xhr, status, error) {
                $("#showTweets").append('Problem with fetch');
            }
        });
    }
</script>

</body>
</html>
