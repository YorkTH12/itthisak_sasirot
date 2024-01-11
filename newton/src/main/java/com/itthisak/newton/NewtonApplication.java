package com.itthisak.newton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itthisak.newton.model.Camera;
import com.itthisak.newton.model.Event;
import com.itthisak.newton.repository.CameraRepository;
import com.itthisak.newton.repository.EventRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class NewtonApplication implements CommandLineRunner{
	private static final Logger logger = LoggerFactory.getLogger(NewtonApplication.class);
	private final CameraRepository cameraRepository;
	private final EventRepository eventRepository;
	
	public NewtonApplication(CameraRepository cameraRepository, EventRepository eventRepository){
		this.cameraRepository = cameraRepository;
		this.eventRepository = eventRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(NewtonApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception{
		cameraRepository.save(new Camera("192.168.1.11", "Machine 1", "CAM-001"));
		cameraRepository.save(new Camera("192.168.1.12", "Machine 2", "CAM-002"));

		eventRepository.save(new Event(1, 200));
		eventRepository.save(new Event(1, 300));
		eventRepository.save(new Event(2, 200));
		eventRepository.save(new Event(2, 300));
		// for(Camera camera : cameraRepository.findAll()){
		// 	logger.info("ip_address: {}, name: {}, location: {} ",
		// 	camera.getIp_address(), camera.getName(), camera.getLocation()	
		// 	);
		// }

		for(Camera camera : cameraRepository.findByIp("192.168.1.12")){
			logger.info(camera.getIp_address(),"name: {}, location: {}");
		}
	}


}


