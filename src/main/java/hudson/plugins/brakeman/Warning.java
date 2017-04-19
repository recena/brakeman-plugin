package hudson.plugins.brakeman;

import hudson.plugins.analysis.util.model.AbstractAnnotation;
import hudson.plugins.analysis.util.model.Priority;

import org.apache.commons.lang.StringUtils;

/**
 * A serializable Java Bean class representing a warning.
 * <p>
 * Note: this class has a natural ordering that is inconsistent with equals.
 * </p>
 *
 * @author Maximilian Odendahl
 */
@SuppressWarnings("PMD.CyclomaticComplexity")
public class Warning extends AbstractAnnotation {
    /** Unique identifier of this class. */
    private static final long serialVersionUID = 1L;

    private String description = StringUtils.EMPTY;

    /**
     * Creates a new instance of <code>Warning</code>.
     *
     * @param fileName
     *            the name of the file
     * @param start
     *            the first line of the line range
     * @param type
     *            the identifier of the warning type
     * @param category
     *            the warning category
     * @param message
     *            the message of the warning
     * @param priority
     *            the priority of the warning
     */
    public Warning(final String fileName, final int start, final int end, final String type, final String category, final String message, final Priority priority) {
        super(priority, message, start, end, category, type);
        setFileName(fileName);
    }

    /**
     * Creates a new instance of <code>Warning</code>.
     *
     * @param fileName
     *            the name of the file
     * @param start
     *            the first line of the line range
     * @param type
     *            the identifier of the warning type
     * @param category
     *            the warning category
     * @param message
     *            the message of the warning
     * @param description
     *            the extended description of the warning

     * @param priority
     *            the priority of the warning
     */
    public Warning(final String fileName, final int start, final int end, final String type, final String category, final String message, final String description, final Priority priority) {
        super(priority, message, start, end, category, type);
        setFileName(fileName);
        this.description = description;
    }

    /** {@inheritDoc} */
    public String getToolTip() {
        return this.description;
    }
}

