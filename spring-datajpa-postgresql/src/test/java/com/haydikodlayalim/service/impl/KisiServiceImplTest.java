package com.haydikodlayalim.service.impl;

import com.haydikodlayalim.dto.KisiDto;
import com.haydikodlayalim.entity.Kisi;
import com.haydikodlayalim.repo.AdresRepository;
import com.haydikodlayalim.repo.KisiRepository;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class KisiServiceImplTest {

    @InjectMocks
    private KisiServiceImpl kisiService;

    @Mock
    private KisiRepository kisiRepository;

    @Mock
    private AdresRepository adresRepository;

    @Test
    public void testSave() {
        KisiDto kisiDto = new KisiDto();
        kisiDto.setAdi("Test-Name");
        kisiDto.setSoyadi("Test-Lastname");
        kisiDto.setAdresler(Arrays.asList("Test-Adres-1"));
        Kisi kisiMock = mock(Kisi.class);

        when(kisiMock.getId()).thenReturn(1L);
        when(kisiRepository.save(ArgumentMatchers.any(Kisi.class))).thenReturn(kisiMock);
        KisiDto result = kisiService.save(kisiDto);

        assertEquals(result.getAdi(), kisiDto.getAdi());
        assertEquals(result.getId(), 1L);
    }
}
