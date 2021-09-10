package healthApp.healthPrj.controller.dto;

import lombok.Data;

@Data
public class Result<T> {

    private Long allDataCount;
    private int dataCount;
    private T data;

    public Result(Long allDataCount, T data) {
        this.allDataCount = allDataCount;
        this.data = data;
    }

    public Result(int dataCount, T data) {
        this.dataCount = dataCount;
        this.data = data;
    }
}
