package club.manager.entrance_cockpit.application.service;

import club.manager.common_library.dto.ClubResponseDTO;
import club.manager.entrance_cockpit.application.mapper.ClubMapper;
import club.manager.entrance_cockpit.domain.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClubService {

    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;
    public ClubResponseDTO getClub(String email){
        return clubRepository.findByEmail(email).map(clubMapper::toDTO).orElse(null);
    }
}
