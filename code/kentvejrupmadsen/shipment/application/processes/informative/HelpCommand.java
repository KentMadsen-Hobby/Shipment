package kentvejrupmadsen.shipment.application.processes.informative;

import kentvejrupmadsen.shipment.application.commands.InformativeCommand;
import kentvejrupmadsen.shipment.application.interactive.Interaction;


/**
 * @author Kent Madsen
 */
public class HelpCommand
        extends InformativeCommand
{
    /**
     * @author Kent Madsen
     */
    public HelpCommand( Interaction actor )
    {
        super("help", actor );
    }
}
