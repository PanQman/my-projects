   M S B A M L   `   `   `  ����G  CDeansOffice1, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null3clr-namespace:DeansOffice1.DALDeansOffice1.DAL  5   	       DeansOffice1.Edycja   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   0localclr-namespace:DeansOffice1.DAL     5   	     � Title$  Edytuj Studenta��5   	   $��351.473��6!   $��308.801��62   .��5	      � -   5         �Name$ 
EdycjaGrid��5	   "   $��0,0,0.2,-19.4q�6   .+�5
   
   �� -   5         ��Name$ button1��5
      $��	Zatwierdz��6"   $
��Left=�66   $��109,286,0,0q�6Q   $	��Top=�6f   $��75��6~   6�   �� 5   
   -   5        $ button2��5      $��Usuń��6"   $
��Left=�61   $��212,286,0,0q�6L   $	��Top=�6a   $��75��6y   6�   �� 5   
   -   5         ��Name$ label��5      $��Nazwisko��6   $
��Left=�62   $��	18,61,0,0q�6M   $	��Top=�6`   $��62��6x   $��23��6�   �� 5   
   -   5         ��Name$ textBoxNazwisko��5      $
��Left=�6E   $��23��6`   $��	92,61,0,0q�6l    �� TextWrapping$
 Wrap=�6   $	��Top=�6�   $	��195��6�   ��6+   �� *
Nazwisko+6�   �� 5   
   -   5        $ textBoxImie��5      $
��Left=�6=   $��23��6X   $��	92,89,0,0q�6d   $
 Wrap=�6w   $	��Top=�6�   $	��195��6�   ��6'   �� *Imie+6�   �� 5   
   -   5        $ textBoxIndeks��5       �� 
IsReadOnly . $
��Left=�6V   $��23��6q   $��
92,117,0,0q�6}   $
 Wrap=�6�   $	��Top=�6�   $	��195��6�   ��6)   �� *	NrIndeksu+6�   �� 5   
   -   5         ��Name$ comboBoxStudia��5       �� SelectedIndex$ 0��6+   	 �� 
IsReadOnly	 . $
��Left=�6o   $��
92,152,0,0q�6�   $	��Top=�6�   $	��195��6�   ��6O   �� *Studia+6�   �� 5   
   -	   5        
 ��Name$
 listBoxPrzedmioty��5      $
��Left=�6Q   $��84��6l   $��
92,189,0,0q�6x   $	��Top=�6�   $	��195��6�   ��6.   �� *
przedmioty+6�   �� 5   
   -
   5        $ 
label_Copy��5      $��
Przedmioty��6$   $
��Left=�69   $��
10,200,0,0q�6T   $	��Top=�6h   $��70��6�   $��30��6�   �� 5   
   -   5        $ label_Copy1��5      $��Studia��6%   $
��Left=�66   $��
18,152,0,0q�6Q   $	��Top=�6e   $��62��6}   $��31��6�   �� 5   
   -   5        $ label_Copy2��5      $��
Nr indeksu��6%   $
��Left=�6:   $��	9,117,0,0q�6U   $	��Top=�6h   $��71��6�   $��23��6�   �� 5   
   -   5        $ label_Copy3��5      $��Imię��6%   $
��Left=�64   $��	35,89,0,0q�6O   $	��Top=�6b   $��45��6z   $��28��6�   �� 5   
   -   5        $ label_Copy4��5      $��Dodaj Studenta��6%   $
��Left=�6>   $��20(�6Y   $��10,10,0,275.4q�6g   $	��149��6~   5      5      