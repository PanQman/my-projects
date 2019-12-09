var express = require('express');
var bodyParser = require('body-parser')
var app = express();
app.use(bodyParser.urlencoded({ extended: false }));

const path = require('path');
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

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


app.get('/hello/', function(req, res){
    res.send('hello world')
});

app.get('/form/', function(req, res){
    res.sendFile(path.join(__dirname + '/index.html'));
});

app.post('/formdata/',function(req,res) {
    var k = req.body.firstName + ' ' +  req.body.lastName + ' ' + req.body.age;
    res.render('index', {
        firstName: req.body.firstName,
        lastName: req.body.lastName,
        age: req.body.age
    })
});