var express = require('express');
var app = express();

app.get('/jwt', function(req,res) {
    res.send('hello\n');
});

app.post('/jwt', function(req,res) {
    res.send('posted\n');
})

app.listen(3000);
console.log('listening on port 3000');