package com.dmitrenko.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AudioDTO {
    private Integer id;
    private Integer duration;
    private Integer gameChatId;
}
