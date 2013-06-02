var restify = require('restify');

var hello = [{
  'id':'0',
  'hello': 'world',
  'say':'what'
},{
  'id':'1',
  'say':'what',
  'hello': 'it is'
}];


function addHeaders(req, res, next) {
  console.log('adding headers');
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "X-Requested-With");
  return next();
};

function logRequest(req, res, next){
  console.log("Got HTTP " + req.method + " on " + req.url + " responding");
  return next();
}

var server = restify.createServer();

server.get('hi', logRequest, addHeaders, function(req, res, next) {
  res.send(hello);
  return next();
});

server.get('hi/:id', logRequest, addHeaders, function(req, res, next){
  res.send(hello[req.params.id]);
  return next();
});

server.patch('hi/:id',logRequest, addHeaders, function(req, res, next){
  var theObject = hello[req.params.id];
  res.send(hello[req.params.id]);
  return next();
});


server.listen(8080, function() {
  console.log('%s listening at %s', server.name, server.url);
});
