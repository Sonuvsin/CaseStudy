import React from 'react';
import UserService from '../../services/amount';
import "./appointment.css"

class Amount extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            users:[]
        }
    }

    componentDidMount(){
        UserService.getUsers().then((response) => {
            this.setState({ users: response.data})
        });
    }

    render (){
        return (
        
            <div>
                <div>
                    <h1 className="bookAppointTitle ">PAYMENT DETAILS</h1>
                </div>
                
                { this.state.users.map((emp)=>(
                                <div className="bk2 " >
                                
                                <div>
                                    <p className="bk3">Name : {emp.fullName}</p>
                                    <p className="bk3">AMOUNT : {emp.amount}</p>
                                    <p className="bk3">BankName: {emp.bankName}</p>
                                </div>
                                <hr style={{marginTop:"30px"}}/>
                            </div>
                            ))
                        }
            </div>
        )
    }
}
    
    export default Amount;