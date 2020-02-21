var express = require('express');

var dt = require('./myfistmodule');

express.createServer(function (req, res){
	res.writeHead(200, {'Content-Type' : 'text/html'});
	res.write("The date and time are currently: " + dt.myDateTime());
	res.end();
})

express.listen(3000, function () {
  console.log('Listening on port 3000!');
});
