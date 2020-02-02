const path = require(`path`);
const express = require(`express`);
const port = 8088;
const expressEdge = require('express-edge');
const mysql = require(`mysql`);
const session = require(`express-session`);
const app = new express();
const bodyParser = require(`body-parser`);

var views = path.join(__dirname, `views`);

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false}));

app.use(express.static(`public`));
//app.use(`/`, express.static(views));

app.use(express.static('/views/', {index: 'index.html'}))

app.use(session({
    secret: 'secret',
    resave: true,
    saveUninitialized: true
}));


app.set('views', __dirname + '/views');
app.use(expressEdge.engine);


//MsSQL
const db = mysql.createConnection ({
    host: `localhost`,
    user: `root`,
    password: ``,
    database: `blogDB`
});
db.connect((err) => {
    if (err) {
        throw err;
    }
    console.log(`Connected to database`);
});
global.db = db;

const { User, Post, Permission } = require('./sequelize');

//create user
app.post('/api/users', (req, res) => {
    User.create(req.body)
        .then(user => res.json(user));
});
//get all users
app.get('/api/users', (req, res) => {
    User.findAll().then(users => res.json(users));
});

//create a blog post
app.post('/post/store', (req, res) => {
    const body = req.body;
    //console.log(body);
    if (body.title === "" || body.post === ""){
            console.log("Puste pola");    
    } else {
        db.query(`INSERT INTO post(post, title, user_id) VALUES ('${body.post}',  '${body.title}', '${req.session.UserId}')`, 
        (err, results) => {
            res.redirect(`/`);
        });
    }
});
//Edit post
app.post('/editpost/:id', (req, res) => {
    const body = req.body;
    console.log(body);   
    db.query(`UPDATE post SET post= '${body.post}', title= '${body.title}' WHERE id = ${req.params.id};`, (err, results) => {
        console.log(`UPDATE post SET post= '${body.post}', title= '${body.title}' WHERE id = ${req.params.id};`);
        console.log(results);
        res.redirect(`/post/${req.params.id}`);
    });
});

//Delete post
app.post('/post/delete/:id', async (req, res) => {
    db.query(`Delete FROM post WHERE id = ${req.params.id}`, (err, results) => {
        //console.log(results);
        res.redirect(`/`);
    });
});

//Create a permission
app.post('api/permissions', (req, res) => {
    Permission.create(req.body).then(permission => res.json(permission));
});

//Login authentication
app.post('/auth/login', (req, res) => {
    const body = req.body;
    const username = body.username;
    const password = body.password;

    if (password && username) {
        db.query(`Select * from user where name = '${username}' and password = '${password}'`, (err, results) => {
            console.log(results);
            if (results.length > 0){
                req.session.loggedin = true;
                req.session.username = username;

                var string = JSON.stringify(results);
                var json =  JSON.parse(string);
                req.session.UserId = json[0].id;
                req.session.permission_id = json[0].permission_id;
                res.redirect(`/`);
            } else {
                res.send('Incorrect username or/and password')
            }
            res.end();
        });
    } else {
        res.send('Please enter username and password');
        res.end();
    }
});

app.get(`/`, async (req, res) => {
    if (req.session.loggedin) {
        const posts = await Post.findAll({order: [
            ['id', 'DESC'],
      ],});
        const user = await User.findByPk(req.session.UserId);
        res.render('index', {posts, user});
    } else {
        res.sendFile(path.join(views, `login.html`));
    }
});

app.get('/post/:id', async (req, res) => {
    if (!req.session.loggedin) {
        res.redirect(`/`);
    } else {
        const post = await Post.findByPk(req.params.id);
        const user = await User.findByPk(req.session.UserId);
        res.render('post', { post, user });
    }
});

app.get('/editpost/:id', async (req, res) => {
    if (!req.session.loggedin) {
        res.redirect(`/`);
    } else {
        const post = await Post.findByPk(req.params.id);
        const user = await User.findByPk(req.session.UserId);
        res.render('edit', { post, user });
    }
});

//Get all permissions
app.get('api/permissions', (req, res) => {
    Permission.findAll().then(permission => res.json(permission));
});

app.get(`/contact`, async (req, res) => {
    if (!req.session.loggedin) {
        res.redirect(`/`);
    } else {
        const user = await User.findByPk(req.session.UserId);
        res.render('contact', { user });
    }
});

app.get(`/about`, async (req, res) => {
    if (!req.session.loggedin) {
        res.redirect(`/`);
    } else {
        const user = await User.findByPk(req.session.UserId);
        res.render('about', { user });
    }
});

app.get(`/create`, async (req, res) => {
    const user = await User.findByPk(req.session.UserId);
    if (!req.session.loggedin || user.permission_id === 3) {
        res.redirect(`/`);
    } else {
       res.sendFile(path.join(views, `create.html`));
    }
});

app.get(`/auth/login`, (req, res) => {
    res.sendFile(path.join(views, `login.html`));
})



app.listen(port, () => {
    console.log(`Running on http://localhost:${port}`);
});






