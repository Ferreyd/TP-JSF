package jsf;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "bean")
@RequestScoped
public class Bean {

    private int nombre;

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public List<Integer> getNombresSuivants() {
        int nb = 5;
        List<Integer> t = new ArrayList<>(nb);
        for (int i = nombre; i < nombre + nb; i++) {
            t.add(i);
        }
        return t;
    }

    /**
     * 
     * @param base est spécifié dans les templates template_formulaire.xhtml et template_affichage.xhtml et prendra les valeurs 'affichage' ou 'formulaire'
     * @param numEx numEx est le numéro de l'exercice et est spécifié dans les pages formulaire_X.xhtml et affichage_X.xhtml
     * @param query query est un nouveau paramètre qui correspond à tout ce qui est après le ? dans l'URL qu'on veut appeler (faces-redirect=true par exemple...). Il doit être spécifié de la même manière que numEx  dans les pages formulaire_X.xhtml et affichage_X.xhtml
     * @return Combinaison des trois parametre sous forme de string
     */
    public String actionString(String base, String numEx, String query) {
        String res =  base + "_" + numEx;
        if(!query.equals("")) // si la variable query n'est pas vide
        {
            res += "?"+ query;
        }
        return res;
    }
}
