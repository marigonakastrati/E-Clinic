/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.services;

import com.jfc.eclinic.dto.Guardian;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mk
 */
public interface GuardianService {
        /**
     *
     * @return @throws Exception
     */
    @NotNull
    List<Guardian> get() throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    Guardian get(@Min(0) int id) throws Exception;

    /**
     *
     * @param value
     * @throws Exception
     */
    void update(@NotNull @Valid Guardian value) throws Exception;

    /**
     *
     * @param value
     * @throws Exception
     */
    void create(@NotNull @Valid Guardian value) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    void delete(Guardian id) throws Exception;

    /**
     *
     * @param value
     * @throws Exception
     */
    public void updateName(Guardian value) throws Exception;

    /**
     *
     * @param value
     * @throws Exception
     */
    public void updatePassword(Guardian value) throws Exception;


}
