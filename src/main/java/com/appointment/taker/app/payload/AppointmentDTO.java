package com.appointment.taker.app.payload;

import java.util.Date;



import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentDTO {

    private int appointmentId;
    
    @NotEmpty
    @Size(min=10, max=10, message = "Oops : Date Must be (DD/MM/YYYY) in this format!!, for example: 20/02/2023")
	private String appointmentDate;
    
    @NotEmpty
    @Size(min=8, max=8, message = "Oops : Time Must be (HH:MM AM/PM) in this format!!, for example: 01:30 AM")
	private String appointmentTime;
	
	@NotEmpty
	@Size(min=4, message="Oops : Proper Appointment Reason is must!!")
	private String appointmentFor;
	
	private Date appointmentSystemDate;
	
//	private UserDTO userDTO;
	
}
