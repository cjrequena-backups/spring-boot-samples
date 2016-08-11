package com.sample.springbatch;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;


/**
 * Un tasklet es una clase que realiza una acción simple. Permite asi ejecutar
 * y realizar cualquier acción que necesitemos. 
 * Spring Batch provee clases más complejas y potentes que los tasklets, pero
 * son igualmente útiles para realizar algunas acciones.
 */
@Data
@Log4j2
public class PrintTasklet implements Tasklet {

    /** Un message a mostrar por pantalla.
     *  Este message será inyectado en el archivo de configuración de Spring.
     */
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    /** La ejecución del tasklet. Spring Batch invoca este método para ejecutar
     * la acción.
     * @return el codigo de estado. Si el codigo es "FINISHED" continua la 
     *         ejecución con la siguiente tarea.
     */
    public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
        log.info(message);
        return RepeatStatus.FINISHED;
    }

}
