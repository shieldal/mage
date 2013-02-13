/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */

package mage.sets.mercadianmasques;

import java.util.UUID;
import mage.Constants.CardType;
import mage.Constants.Rarity;
import mage.Constants.Zone;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.costs.mana.GenericManaCost;
import mage.abilities.effects.common.search.SearchLibraryPutInPlayEffect;
import mage.cards.CardImpl;
import mage.filter.Filter.ComparisonType;
import mage.filter.common.FilterCreatureCard;
import mage.filter.predicate.mageobject.ConvertedManaCostPredicate;
import mage.filter.predicate.mageobject.SubtypePredicate;
import mage.target.common.TargetCardInLibrary;

/**
 *
 * @author Backfir3
 */
public class RamosianSergeant extends CardImpl<RamosianSergeant> {

    private static final FilterCreatureCard filter = new FilterCreatureCard("Rebel permanent card with converted mana cost 2 or less");

    static {
        filter.add(new SubtypePredicate("Rebel"));
		filter.add(new ConvertedManaCostPredicate(ComparisonType.LessThan, 3));
    }

    public RamosianSergeant(UUID ownerId) {
		super(ownerId, 39, "Ramosian Sergeant", Rarity.COMMON, new CardType[]{CardType.CREATURE}, "{W}");
		this.expansionSetCode = "MMQ";
		this.subtype.add("Human");
		this.subtype.add("Rebel");
		this.color.setWhite(true);
		this.power = new MageInt(1);
		this.toughness = new MageInt(1);
	
		// {3}, {T}: Search your library for a Rebel permanent card with converted mana cost 2 or less and put it onto the battlefield. Then shuffle your library.
		Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new SearchLibraryPutInPlayEffect(new TargetCardInLibrary(filter)), new TapSourceCost());
		ability.addManaCost(new GenericManaCost(3));
		this.addAbility(ability);
    }

    public RamosianSergeant(final RamosianSergeant card) {
        super(card);
    }

    @Override
    public RamosianSergeant copy() {
        return new RamosianSergeant(this);
    }

}