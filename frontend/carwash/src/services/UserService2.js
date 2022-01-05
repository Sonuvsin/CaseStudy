import axios from 'axios';

var session_url = 'http://api_address/api/session_endpoint';
var uname = 'user';
var pass = 'password';
axios.post(session_url, {}, {
  auth: {
    username: uname,
    password: pass
  }
}).then(function(response) {
  console.log('Authenticated');
}).catch(function(error) {
  console.log('Error on Authentication');
});