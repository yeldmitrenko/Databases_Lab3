package com.dmitrenko.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MediaDTO {
    private Integer id;
    private String name;
    private Double size;
    private Integer date;
    private Integer gameChatId;
}
