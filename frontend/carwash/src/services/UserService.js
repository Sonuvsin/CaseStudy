import axios from 'axios'

const API_URL = 'http://localhost:8080/user/allusers';

class UserService {

    login(username,password){
        return axios.get(API_URL , {username,password});
    }
}


export default new UserService();