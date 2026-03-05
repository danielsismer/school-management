package com.school.management.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursoResponseDTO {

    Long id;
    String nome;
    String codigo;
    List<String> professore;

}
