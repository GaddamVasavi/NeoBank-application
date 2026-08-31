import { describe, it, expect } from 'vitest';
import { render, screen } from '@testing-library/react';
import React from 'react';
import { Button } from '../components/ui/Button';

describe('Button Component', () => {
  it('renders correctly with children', () => {
    render(<Button>Submit Transfer</Button>);
    expect(screen.getByText('Submit Transfer')).toBeDefined();
  });
});
