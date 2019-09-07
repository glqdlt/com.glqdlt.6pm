package com.glqdlt.pm6.entity.user.log;

import java.util.LinkedList;
import java.util.List;

/**
 * Date 2019-08-10
 *
 * @author glqdlt
 */
public abstract class LogWriter<T extends Log> {
    private final List<T> log = new LinkedList<>();

    public void add(T log) {
        this.log.add(log);
    }

    public void adds(List<T> logs) {
        this.log.addAll(logs);
    }

    public abstract List<T> write();
}
