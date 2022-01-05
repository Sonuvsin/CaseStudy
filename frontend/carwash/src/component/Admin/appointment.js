import React from 'react';
import UserService from '../../services/appointment';
import "./appointment.css"

class UserComponent extends React.Component {

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
                    <h1 className="bookAppointTitle ">APPOINTMENT DETAILS</h1>
                </div>
                
                { this.state.users.map((emp)=>(
                                <div className="bk2 " >
                                
                                <div>
                                    <p className="bk3">Name : {emp.Name}</p>
                                    <p className="bk3">Car Name : {emp.carName}</p>
                                    <p className="bk3">Car Model: {emp.carModel}</p>
                                    <p className="bk3">Address: {emp.address}</p>
                                    <p className="bk3">Appointment Date : {emp.date}</p>

                                    <p className="bk3">Contact-No : {emp.contactno}</p>
                                    <p className="bk3">WashPAck : {emp.washpackName}</p>
                                    
                                    
                                    <button className="bookBtn2" >Confirm Appointment</button>
                                </div>
                                <hr style={{marginTop:"30px"}}/>
                            </div>
                            ))
                        }
            </div>
        )
    }
}
    
    export default UserComponent;