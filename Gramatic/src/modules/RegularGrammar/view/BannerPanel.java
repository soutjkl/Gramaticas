package modules.RegularGrammar.view;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BannerPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private static final String ICON_PATH = "/modules/RegularGrammar/img/grammaricon.png";
	
	public BannerPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setBackground(Color.WHITE);
		
		JLabel bannerLabel = new JLabel();
		bannerLabel.setIcon(new ImageIcon(getClass().getResource(ICON_PATH)));
		bannerLabel.setBackground(Color.WHITE);
		bannerLabel.setAlignmentX(CENTER_ALIGNMENT);
		add(bannerLabel);
	}
}


