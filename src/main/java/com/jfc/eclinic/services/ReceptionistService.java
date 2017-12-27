
package main.java.com.jfc.eclinic.services;

import com.jfc.eclinic.dto.Receptionist;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mk
 */
public interface ReceptionistService {

    /**
     *
     * @return @throws Exception
     */
    @NotNull
    List<Receptionist> get() throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    Receptionist get(@Min(0) int id) throws Exception;

    /**
     *
     * @param value
     * @throws Exception
     */
    void update(@NotNull @Valid Receptionist value) throws Exception;

    /**
     *
     * @param value
     * @throws Exception
     */
    void create(@NotNull @Valid Receptionist value) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    void delete(Receptionist id) throws Exception;

}
