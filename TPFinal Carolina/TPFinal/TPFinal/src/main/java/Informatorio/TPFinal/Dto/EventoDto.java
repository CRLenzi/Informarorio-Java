package Informatorio.TPFinal.Dto;

public class EventoDto {
    private Long eventoId;
    private Long suscriptorId;
    
    public Long getEventId() {
        return eventoId;
    }
    public void setEventId(Long eventId) {
        this.eventoId = eventId;
    }
    public Long getSuscriptorId() {
        return suscriptorId;
    }
    public void setSuscriptorId(Long suscriptorId) {
        this.suscriptorId = suscriptorId;
    }
}