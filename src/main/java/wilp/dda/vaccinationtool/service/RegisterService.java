package wilp.dda.vaccinationtool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wilp.dda.vaccinationtool.repository.RegisterRepository;
import wilp.dda.vaccinationtool.repository.entity.RegisterEntity;
import wilp.dda.vaccinationtool.web.appointment.model.AppointmentResponse;
import wilp.dda.vaccinationtool.web.appointment.model.BookAppointmentRequest;
import wilp.dda.vaccinationtool.web.appointment.model.UpdateAppointmentRequest;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository repository;

    public void bookAppointment(BookAppointmentRequest request) {
        repository.save(RegisterEntity.builder().build());
    }

//    public void updateAppointment(String registrationId, UpdateAppointmentRequest request) {
//        repository.findById(registrationId).ifPresent(appointmentEntity -> repository.save(appointmentEntity));
//    }
//
//    public AppointmentResponse getAppointment(String registrationId) {
//        repository.findById(registrationId);
//        return AppointmentResponse.builder().build();
//    }

    public List<AppointmentResponse> getAppointment() {
        repository.findAll();
        return new ArrayList<>();
    }
}
