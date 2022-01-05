import axios from 'axios'

const USERS_REST_API_URL = 'http://localhost:8085/order/allorders';

class UserService {

    getUsers(){
        return axios.get(USERS_REST_API_URL);
    }
}

export default new UserService();