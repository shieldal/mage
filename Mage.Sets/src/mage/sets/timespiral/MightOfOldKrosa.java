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
package mage.sets.timespiral;

import java.util.UUID;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Rarity;
import mage.abilities.condition.common.MyMainPhaseCondition;
import mage.abilities.decorator.ConditionalContinousEffect;
import mage.abilities.effects.common.continious.BoostTargetEffect;
import mage.cards.CardImpl;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author LevelX2
 */
public class MightOfOldKrosa extends CardImpl {

    public MightOfOldKrosa(UUID ownerId) {
        super(ownerId, 204, "Might of Old Krosa", Rarity.UNCOMMON, new CardType[]{CardType.INSTANT}, "{G}");
        this.expansionSetCode = "TSP";

        this.color.setGreen(true);

        // Target creature gets +2/+2 until end of turn. If you cast this spell during your main phase, that creature gets +4/+4 until end of turn instead.
        this.getSpellAbility().addEffect(new ConditionalContinousEffect(
                new BoostTargetEffect(4,4, Duration.EndOfTurn),
                new BoostTargetEffect(2, 2, Duration.EndOfTurn),
                MyMainPhaseCondition.getInstance(),
                "Target creature gets +2/+2 until end of turn. If you cast this spell during your main phase, that creature gets +4/+4 until end of turn instead",
                true));
        this.getSpellAbility().addTarget(new TargetCreaturePermanent());
    }

    public MightOfOldKrosa(final MightOfOldKrosa card) {
        super(card);
    }

    @Override
    public MightOfOldKrosa copy() {
        return new MightOfOldKrosa(this);
    }
}
