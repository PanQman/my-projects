var express = require('express');
const app = express();
const path = require('path');

app.set('views', path.join(__dirname, 'views'));
//app.set('views', './views');
app.set('view engine', 'ejs'); 

var bodyParser = require('body-parser')
app.use(bodyParser.urlencoded({ extended: false }));

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
    res.render(path.join(__dirname + '/index.ejs'));
    console.log(path.join(__dirname));
    console.log(__dirname);
});

app.post('/formdata/',function(req,res) {
    var k = {
      firstName: req.body.firstName,
      lastName: req.body.lastName,
      age: req.body.age
    };
    //res.render('index', k); //{
    res.render((path.join(__dirname + '/index.ejs')), k);
    //})
});
//node .\First_Project\app\app2.js