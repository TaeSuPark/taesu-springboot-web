package com.taesu.project01.springboot.web.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat; // JUnit의 기본 assertThat이 아닌 assertj의 assertThat 사용

public class HelloResponseDtoTest {

    @Test
    public void lombokTest() {

        // given
        String name = "test";
        int amount = 1000;

        // when
        //dto 객체 생성, test / 1000
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        // 객체의 get 메소드를 한 값과 같은지 판단 -> get 메소드가 잘 동작하는지 판단
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }


}
