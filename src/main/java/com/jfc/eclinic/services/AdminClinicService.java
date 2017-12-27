
package com.jfc.eclinic.services;

import com.jfc.eclinic.dto.Adminclinic;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mk
 */
public interface AdminClinicService {

    /**
     *
     * @return @throws Exception
     */
    @NotNull
    List<Adminclinic> get() throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    Adminclinic get(@Min(0) int id) throws Exception;

    /**
     *
     * @param value
     * @throws Exception
     */
    void update(@NotNull @Valid Adminclinic value) throws Exception;

    /**
     *
     * @param value
     * @throws Exception
     */
    void create(@NotNull @Valid Adminclinic value) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    void delete(Adminclinic id) throws Exception;

}
