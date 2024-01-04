package com.tolgaozgun.gdscturkweb.service;

import com.tolgaozgun.gdscturkweb.dto.AnnouncementDTO;
import com.tolgaozgun.gdscturkweb.dto.request.announcement.CreateAnnouncementRequest;
import com.tolgaozgun.gdscturkweb.dto.request.announcement.EditAnnouncementRequest;
import com.tolgaozgun.gdscturkweb.entity.AnnouncementEntity;
import com.tolgaozgun.gdscturkweb.entity.user.UserEntity;
import com.tolgaozgun.gdscturkweb.enums.UserType;
import com.tolgaozgun.gdscturkweb.exception.AnnouncementNotFoundException;
import com.tolgaozgun.gdscturkweb.mapper.AnnouncementMapper;
import com.tolgaozgun.gdscturkweb.repository.AnnouncementRepository;
import com.tolgaozgun.gdscturkweb.repository.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AnnouncementServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AnnouncementRepository announcementRepository;

    @Mock
    private AnnouncementMapper announcementMapper;

    @Mock
    private AuthService authService;

    @InjectMocks
    private AnnouncementService announcementService;

    private AnnouncementEntity mockAnnouncementEntity;
    private AnnouncementDTO mockAnnouncementDTO;
    private UserEntity mockUserEntity;

    @BeforeEach
    void setUp() {
        // Initialize mock objects
        mockAnnouncementEntity = new AnnouncementEntity();
        mockAnnouncementDTO = new AnnouncementDTO();
        mockUserEntity = new UserEntity();
        mockUserEntity.setUserType(UserType.ADMIN);

        // Common mock setups
        when(authService.getCurrentUserEntity()).thenReturn(mockUserEntity);
    }

    @Test
    public void testGetAllAnnouncementsByUserType() {
        // Arrange
        List<AnnouncementEntity> mockEntities = List.of(mockAnnouncementEntity);
        List<AnnouncementDTO> mockDTOs = List.of(mockAnnouncementDTO);
        when(announcementRepository.findAllByPermittedUserTypesContainingAndStartDateIsBeforeAndEndDateIsAfter(
                any(UserType.class), any(Date.class), any(Date.class))
        ).thenReturn(mockEntities);
        when(announcementMapper.toDTO(mockEntities)).thenReturn(mockDTOs);

        // Act
        List<AnnouncementDTO> result = announcementService.getAllAnnouncementsByUserType();

        // Assert
        assertEquals(mockDTOs, result);
        verify(announcementRepository).findAllByPermittedUserTypesContainingAndStartDateIsBeforeAndEndDateIsAfter(
                any(UserType.class), any(Date.class), any(Date.class)
        );
        verify(announcementMapper).toDTO(mockEntities);
    }

    @Test
    public void testGetAllAnnouncements() {
        // Arrange
        List<AnnouncementEntity> mockEntities = List.of(mockAnnouncementEntity);
        List<AnnouncementDTO> mockDTOs = List.of(mockAnnouncementDTO);
        when(announcementRepository.findAll()).thenReturn(mockEntities);
        when(announcementMapper.toDTO(mockEntities)).thenReturn(mockDTOs);

        // Act
        List<AnnouncementDTO> result = announcementService.getAllAnnouncements();

        // Assert
        assertEquals(mockDTOs, result);
        verify(announcementRepository).findAll();
        verify(announcementMapper).toDTO(mockEntities);
    }

    @Test
    public void testGetAnnouncementById() {
        // Arrange
        Long announcementId = 1L;
        when(announcementRepository.findById(announcementId)).thenReturn(Optional.of(mockAnnouncementEntity));
        when(announcementMapper.toDTO(mockAnnouncementEntity)).thenReturn(mockAnnouncementDTO);

        // Act
        AnnouncementDTO result = announcementService.getAnnouncementById(announcementId);

        // Assert
        assertEquals(mockAnnouncementDTO, result);
        verify(announcementRepository).findById(announcementId);
        verify(announcementMapper).toDTO(mockAnnouncementEntity);
    }

    @Test
    public void testGetAnnouncementById_NotFound() {
        // Arrange
        Long announcementId = 1L;
        when(announcementRepository.findById(announcementId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(AnnouncementNotFoundException.class, () -> {
            announcementService.getAnnouncementById(announcementId);
        });
    }

    @Test
    public void testCreateAnnouncement() {
        // Arrange
        CreateAnnouncementRequest request = new CreateAnnouncementRequest();
        request.setTitle("Test Title");
        request.setDescription("Test Description");
        request.setStartDate(new Date());
        request.setEndDate(new Date());
        request.setPermittedUserTypes(List.of(UserType.ADMIN));

        when(announcementRepository.save(any(AnnouncementEntity.class))).thenReturn(mockAnnouncementEntity);
        when(announcementMapper.toDTO(mockAnnouncementEntity)).thenReturn(mockAnnouncementDTO);

        // Act
        AnnouncementDTO result = announcementService.createAnnouncement(request);

        // Assert
        assertEquals(mockAnnouncementDTO, result);
        verify(announcementRepository).save(any(AnnouncementEntity.class));
        verify(announcementMapper).toDTO(mockAnnouncementEntity);
    }

    @Test
    public void testEditAnnouncement() {
        // Arrange
        Long announcementId = 1L;
        EditAnnouncementRequest editRequest = new EditAnnouncementRequest();
        editRequest.setTitle("Updated Title");
        editRequest.setDescription("Updated Description");
        editRequest.setStartDate(new Date());
        editRequest.setEndDate(new Date());
        editRequest.setPermittedUserTypes(List.of(UserType.ADMIN));

        when(announcementRepository.findById(announcementId)).thenReturn(Optional.of(mockAnnouncementEntity));
        when(announcementRepository.save(any(AnnouncementEntity.class))).thenReturn(mockAnnouncementEntity);
        when(announcementMapper.toDTO(mockAnnouncementEntity)).thenReturn(mockAnnouncementDTO);

        // Act
        AnnouncementDTO result = announcementService.editAnnouncement(announcementId, editRequest);

        // Assert
        assertEquals(mockAnnouncementDTO, result);
        verify(announcementRepository).findById(announcementId);
        verify(announcementRepository).save(any(AnnouncementEntity.class));
        verify(announcementMapper).toDTO(mockAnnouncementEntity);
    }

    @Test
    public void testEditAnnouncement_NotFound() {
        // Arrange
        Long announcementId = 1L;
        EditAnnouncementRequest editRequest = new EditAnnouncementRequest();
        when(announcementRepository.findById(announcementId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(AnnouncementNotFoundException.class, () -> {
            announcementService.editAnnouncement(announcementId, editRequest);
        });
    }


}
