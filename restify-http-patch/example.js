;(function(){
 $.getJSON('http://localhost:8080/hi/1', function(data) {
    $('#say').text(data.say);
 });
}())
