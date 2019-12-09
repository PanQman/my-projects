
var express = require('express');
var app = express();
app.set('view engine', 'ejs');

app.set('views', __dirname + '/views');

app.get('/', function (req, res) {
  res.send('Hello World!');
});

app.listen(3000, function () {
  console.log('Example app listening on port 3000!');
});


app.use((err, req, res, next) => {
  res.locals.error = err;
  const status = err.status || 500;
  res.status(status);
  res.render('error');
});


app.get('/add/', function(req, res){
  var p1 = parseInt(req.query.param1);
  var p2 = parseInt(req.query.param2);
  if (isNaN(p1) || isNaN(p2)){
    res.status(400).send("Brak lub niewłaściwe parametry")
  } else {
    res.send(p1 + p2 + '');
}});

app.get('/sub/', function(req, res){
  var p1 = parseInt(req.query.param1);
  var p2 = parseInt(req.query.param2);
  if (isNaN(p1) || isNaN(p2)){
    res.status(400).send("Brak lub niewłaściwe parametry")
  } else {
  res.send(p1 - p2 + '');
}});

app.get('/mul/', function(req, res){
  var p1 = parseInt(req.query.param1);
  var p2 = parseInt(req.query.param2);
  if (isNaN(p1) || isNaN(p2)){
    res.status(400).send("Brak lub niewłaściwe parametry")
  } else {
  res.send(p1 * p2 + '');
}});

app.get('/div/', function(req, res){
  var p1 = parseInt(req.query.param1);
  var p2 = parseInt(req.query.param2);
  if (isNaN(p1) || isNaN(p2)){
    res.status(400).send("Brak lub niewłaściwe parametry")
  } else {
  res.send(p1 / p2 + '');
}});