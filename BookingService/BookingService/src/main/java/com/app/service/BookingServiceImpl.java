package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import com.app.entity.BookingStatus;
import com.app.exception.BookingException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.BookingDto;
import com.app.entity.Booking;
import com.app.repository.BookingRepo;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo bookingRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Creates a new booking.
     * 
     * @param bookingDto The data transfer object containing booking details.
     * @return The created booking as a BookingDto.
     * @throws BookingException If the staff is not available at the requested time.
     */
    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        // Convert BookingDto to Booking entity
        Booking booking = modelMapper.map(bookingDto, Booking.class);
        // Set the status of the booking to PENDING
        booking.setStatus(BookingStatus.PENDING);

        // Check if the staff is available at the requested time
        List<Booking> staffBooking = bookingRepository.findByStaffId(booking.getStaffId());
        if (staffBooking != null) {
            for (Booking booking1 : staffBooking) {
                if (booking1.getTime().equalsIgnoreCase(booking.getTime())) {
                    // Throw an exception if the staff is not available
                    throw new BookingException("Staff not available");
                }
            }
        }

        // Save the new booking to the database
        Booking savedBooking = bookingRepository.save(booking);
        // Convert the saved Booking entity back to a BookingDto and return it
        return modelMapper.map(savedBooking, BookingDto.class);
    }

    /**
     * Retrieves a booking by its ID.
     * 
     * @param id The ID of the booking.
     * @return The booking as a BookingDto.
     * @throws BookingException If the booking is not found.
     */
    @Override
    public BookingDto getBookingById(Long id) {
        // Find the booking by ID, throw an exception if not found
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingException("Booking not found with id: " + id));
        // Convert the found Booking entity to a BookingDto and return it
        return modelMapper.map(booking, BookingDto.class);
    }

    /**
     * Updates an existing booking by its ID.
     * 
     * @param id The ID of the booking to update.
     * @param bookingDto The data transfer object containing the updated booking details.
     * @return The updated booking as a BookingDto.
     * @throws BookingException If the booking is not found.
     */
    @Override
    public BookingDto updateBooking(Long id, BookingDto bookingDto) {
        // Find the existing booking by ID, throw an exception if not found
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingException("Booking not found with id: " + id));

        // Map the fields from BookingDto to the existing Booking entity
        Booking booking = modelMapper.map(bookingDto, Booking.class);
        // Preserve certain fields from the existing booking
        booking.setPrice(existingBooking.getPrice());
        booking.setStatus(bookingDto.getStatus());

        // Save the updated booking to the database
        Booking updatedBooking = bookingRepository.save(booking);
        // Convert the updated Booking entity to a BookingDto and return it
        return modelMapper.map(updatedBooking, BookingDto.class);
    }

    /**
     * Deletes a booking by its ID.
     * 
     * @param id The ID of the booking to delete.
     * @return A confirmation message.
     * @throws BookingException If the booking is not found.
     */
    @Override
    public String deleteBooking(Long id) {
        // Find the booking by ID, throw an exception if not found
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingException("Booking not found with id: " + id));
        // Delete the booking from the database
        bookingRepository.delete(booking);
        // Return a confirmation message
        return "Deleted Successfully";
    }

    /**
     * Retrieves all bookings.
     * 
     * @return A list of all bookings as BookingDto.
     */
    @Override
    public List<BookingDto> getAllBookings() {
        // Retrieve all bookings from the database
        List<Booking> bookings = bookingRepository.findAll();
        // Convert the list of Booking entities to a list of BookingDto and return it
        return bookings.stream().map(booking -> modelMapper.map(booking, BookingDto.class))
                .collect(Collectors.toList());
    }
}
