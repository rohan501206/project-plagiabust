/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportingModule;

/**
 *
 * @author nuwan
 */
public class FileMarkerGraph {

    private String filename;

    public FileMarkerGraph(String nameTemp) {

        filename = nameTemp;

    }

    public FileMarkerGraph() {
    }

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }
}
