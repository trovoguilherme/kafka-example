package br.com.skeleton.core.entity;

import lombok.Data;

@Data
public class Message {

    public enum Status {
        WAITING, SEND
    }

    private String id;

    private String title;

    private String content;

    private Status status;

    public br.com.skeleton.avro.Message toAvro() {
        return br.com.skeleton.avro.Message.newBuilder()
                .setId(id)
                .setTitle(title)
                .setContent(content)
                .setStatus(status.name())
                .build();
    }

}
