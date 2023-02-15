package com.appointment.taker.app.payload;

import java.util.ArrayList;
import java.util.List;

import com.appointment.taker.app.entities.Appointment;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
	

    private int userId;
	
    @NotEmpty
	@Size(min=2, message="Oops : User Name contains must be atleast two characters!!")
	private String userName;
    
    @NotEmpty
    @Email(message="Oops : Email Id incorrect!! :( -> Please enter correct Email Id :)")
	private String userEmail;
    
    @NotEmpty
    @Size(min=10, message="Oops : Mobile number is less than 10 Numbers!! :( -> Please enter correct Mobile Number :)")
	private String userMobileNumber;
    
    @NotEmpty
    @Size(min=10, message="Oops : WhatsApp number is less than 10 Numbers!! :( -> Please enter correct WhatsApp Number :)")
	private String userWhatsAppNumber;
    
    @NotEmpty
    @Size(min=6, message="Oops : Password is less than 6 character!! :( -> Please enter correct Password :)")
	private String userPassword;
    
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<Appointment> appointment = new ArrayList<>();
    
    private List<AppointmentDTO> appointmentDTO = new ArrayList<>();

}
