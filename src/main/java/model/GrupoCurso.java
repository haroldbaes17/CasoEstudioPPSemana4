package model;

public class GrupoCurso {
    private int id;
    private int idGrupo;
    private int idCurso;

    public GrupoCurso(int id, int idGrupo, int idCurso) {
        this.id = id;
        this.idGrupo = idGrupo;
        this.idCurso = idCurso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
}
