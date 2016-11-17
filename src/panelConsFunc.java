import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

@SuppressWarnings("serial")
public class panelConsFunc extends JPanel{
	// WIP -------- criação da interface para consulta de funcionários
	private JTable table;
	private JComboBox filtroBox;
	private JLabel lblCargo;
	private String[] cabecalhoTabl = {"CPF",
									  "Nome",
									  "Sexo",
									  "Data nasc.",
									  "E-mail",
									  "Rua",
									  "Num.",
									  "Bairro",
									  "Complemento",
									  "Cod. Func.",
									  "Cargo",
									  "Passaporte",
									  "Necess. Especial?"};
	private JTableHeader header;
	
	public panelConsFunc(UserInterface window, JPanel ant) {
		setLayout(new MigLayout("", "[grow][grow]", "[][grow]"));
		
		lblCargo = new JLabel("Cargo: ");
		add(lblCargo, "cell 0 0,alignx right");
		
		filtroBox = new JComboBox();
		filtroBox.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Interno", "Piloto", "Comiss\u00E1rio", "T\u00E9cnico"}));
		add(filtroBox, "cell 1 0,alignx left");
		
		table = new JTable();
		add(table, "cell 0 1 2 1,grow");
	
		table;
	}
	
	
	
}
