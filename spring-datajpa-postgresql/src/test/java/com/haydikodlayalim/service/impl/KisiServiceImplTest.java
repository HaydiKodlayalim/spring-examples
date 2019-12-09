package com.haydikodlayalim.service.impl;

import com.haydikodlayalim.dto.KisiDto;
import com.haydikodlayalim.entity.Adres;
import com.haydikodlayalim.entity.Kisi;
import com.haydikodlayalim.repo.AdresRepository;
import com.haydikodlayalim.repo.KisiRepository;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test
    public void testSaveException() {
        KisiDto kisiDto = new KisiDto();
        kisiDto.setSoyadi("Test-Lastname");
        kisiDto.setAdresler(Arrays.asList("Test-Adres-1"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> kisiService.save(kisiDto));
    }

    @Test
    public void testGetAll() {
        Kisi kisi = new Kisi();
        kisi.setId(1L);
        kisi.setAdi("Test-Name");
        kisi.setSoyadi("Test-Lastname");

        when(kisiRepository.findAll()).thenReturn(Collections.singletonList(kisi));
        List<KisiDto> kisiDtos = kisiService.getAll();

        assertEquals(kisiDtos.size(), 1);
        assertEquals(kisiDtos.get(0), KisiDto.builder().id(1L).build());
    }

    @Test
    public void testGetAllWithAddress() {
        Kisi kisi = new Kisi();
        kisi.setId(1L);
        kisi.setAdi("Test-Name");
        kisi.setSoyadi("Test-Lastname");

        Adres ad = new Adres();
        ad.setAdresTip(Adres.AdresTip.DIGER);
        ad.setAdres("Test Adres");
        kisi.setAdresleri(Collections.singletonList(ad));

        when(kisiRepository.findAll()).thenReturn(Collections.singletonList(kisi));
        List<KisiDto> kisiDtos = kisiService.getAll();

        assertEquals(kisiDtos.get(0).getAdresler().size(), 1);
    }
}
